import { useState, useEffect } from "react";

export default function InventoryList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetch('/api/inventory')
      .then(res => res.json())
      .then(data => setItems(data))
      .catch(err => console.error('Error fetching inventory:', err));
  }, []);

  return (
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Stock Name</th>
          <th>Aisle</th>
          <th>Shelf</th>
          <th>Quantity</th>
          <th>Stock Price</th>
        </tr>
      </thead>
      <tbody>
        {items.map(item => (
          <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.name}</td>
            <td>{item.aisle}</td>
            <td>{item.shelf}</td>
            <td>{item.quantity}</td>
            <td>${item.price.toFixed(2)}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}