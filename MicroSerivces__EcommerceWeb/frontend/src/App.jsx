import { useState } from 'react'
import axios from 'axios'
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

// Mock base URLs for each service
const USER_SERVICE_URL = 'http://userservice:8081'
const PRODUCT_SERVICE_URL = 'http://productservice:8082'
const ORDER_SERVICE_URL = 'http://orderservice:8083'
const CHECKOUT_SERVICE_URL = 'http://checkoutservice:8084'
const PAYMENT_SERVICE_URL = 'http://paymentservice:8085'

function App() {
  const [user, setUser] = useState(null)
    const [products, setProducts] = useState([])
    const [order, setOrder] = useState(null)
    const [checkoutStatus, setCheckoutStatus] = useState('')
    const [paymentStatus, setPaymentStatus] = useState('')

      // UserService
  const login = async () => {
    try {
      const response = await axios.post(`${USER_SERVICE_URL}/login`, { username: 'testuser', password: 'testpass' })
      setUser(response.data)
    } catch (error) {
      console.error('Login failed:', error)
    }
  }

  const logout = () => {
    setUser(null)
  }

  // ProductService
  const fetchProducts = async () => {
    try {
      const response = await axios.get(`${PRODUCT_SERVICE_URL}/all`)
      setProducts(response.data)
    } catch (error) {
      console.error('Failed to fetch products:', error)
    }
  }

  // OrderService
  const createOrder = async () => {
    try {
      const response = await axios.post(`${ORDER_SERVICE_URL}/create`, { userId: user.id, products: [1, 2, 3] })
      setOrder(response.data)
    } catch (error) {
      console.error('Failed to create order:', error)
    }
  }

  // CheckoutService
  const processCheckout = async () => {
    try {
      const response = await axios.post(`${CHECKOUT_SERVICE_URL}/process`, { orderId: order.id })
      setCheckoutStatus(response.data.status)
    } catch (error) {
      console.error('Checkout failed:', error)
    }
  }

  // PaymentService
  const processPayment = async () => {
    try {
      const response = await axios.post(`${PAYMENT_SERVICE_URL}/process`, { orderId: order.id, amount: order.total })
      setPaymentStatus(response.data.status)
    } catch (error) {
      console.error('Payment failed:', error)
    }
  }

  return (
    <>

    <div className="container mx-auto p-4 space-y-4">
      <Card>
        <CardHeader>
          <CardTitle>User Service</CardTitle>
        </CardHeader>
        <CardContent>
          {user ? (
            <div>
              <p>Logged in as: {user.username}</p>
              <Button onClick={logout}>Logout</Button>
            </div>
          ) : (
            <Button onClick={login}>Login</Button>
          )}
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle>Product Service</CardTitle>
        </CardHeader>
        <CardContent>
          <Button onClick={fetchProducts}>Fetch Products</Button>
          {products.length > 0 && (
            <ul className="mt-2">
              {products.map(product => (
                <li key={product.id}>{product.name}</li>
              ))}
            </ul>
          )}
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle>Order Service</CardTitle>
        </CardHeader>
        <CardContent>
          <Button onClick={createOrder} disabled={!user}>Create Order</Button>
          {order && <p className="mt-2">Order created: {order.id}</p>}
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle>Checkout Service</CardTitle>
        </CardHeader>
        <CardContent>
          <Button onClick={processCheckout} disabled={!order}>Process Checkout</Button>
          {checkoutStatus && <p className="mt-2">Checkout status: {checkoutStatus}</p>}
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle>Payment Service</CardTitle>
        </CardHeader>
        <CardContent>
          <Button onClick={processPayment} disabled={!order || checkoutStatus !== 'completed'}>Process Payment</Button>
          {paymentStatus && <p className="mt-2">Payment status: {paymentStatus}</p>}
        </CardContent>
      </Card>
    </div>

    </>
  )
}

export default App
