import React, { useLayoutEffect, useState } from 'react';
import { getCurrency } from '../Utils';

//const products=[{"productId":1,"name":"Strong Joints Dog Supplement","price":5.87,"vendorId":9},{"productId":2,"name":"Healthy Coat Dog Supplement","price":6.44,"vendorId":4},{"productId":3,"name":"Probiotic Dog Treats","price":8.89,"vendorId":10},{"productId":4,"name":"Small Hypoallergenic Pet Bowl","price":6.55,"vendorId":13},{"productId":5,"name":"Large Hypoallergenic Pet Bowl","price":8.14,"vendorId":13},{"productId":6,"name":"Cat Hairball Remedy Gel","price":6.00,"vendorId":14}]

const Products = () => {
  const [products, setProducts] = useState([])
  const [vendors, setVendors] = useState(new Map())

  const add = (key, value) => {
    setVendors(prev => new Map([...prev, [key, value]]))
  }

  useLayoutEffect(() => {
      const getProducts = async() => {
        const res = await fetch('/api/products')
        const products = await res.json()
        setProducts(products)
      }
      const getVendors = async () => {
        const res = await fetch('/api/vendors')
        const vendors = await res.json()
        vendors.map(vendor => {
          const {
            vendorId,
            name,

          } = vendor;
          add(vendorId, vendor)
        })
      }
      getProducts().catch(e => {
        console.log("error fetching products: " + e)
      });
      getVendors().catch(e => {
        console.log("error fetching vendors: " + e)
      })
    },[]
  )
  return (
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Vendor</th>
      </tr>
      </thead>
      <tbody>
      {products.map(product => {
        const {
          productId,
          name,
          price,
          vendorId
        } = product;
        return (
          <tr key={product}>
            <td>{productId}</td>
            <td>{name}</td>
            <td>{getCurrency(price)}</td>
            <td>{vendors.get(vendorId).name}</td>
          </tr>
        )
      })}
      </tbody>
    </table>
  )
}

export default Products;
