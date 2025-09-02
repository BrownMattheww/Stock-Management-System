import { useState, useEffect } from "react";
import './InventoryManager.css';



export default function InventoryList() {
  const [items, setItems] = useState([]);

  async function getInventoryItems() {
    try {
      const response = await fetch("http://localhost:8080/stockLocation", {method: "GET"})
      if(!response.ok){
        throw new Error(`Response status: ${response.status}`);
      }

      const results = await response.json();
      setItems(results);
      console.log(results);

    } catch (error) {
      console.error(error.message);
    }
  }

  useEffect(() => {
    getInventoryItems();
  }, []);

  return (
    <table>
      <thead>
        <tr>
          <th>Stock Name</th>
          <th>Aisle</th>
          <th>Shelf</th>
          <th>Quantity</th>
          <th>Stock Price</th>
        </tr>
      </thead>
      <tbody>
        {items.map(item => (
          <tr key={item.stockName}>
            <td>{item.stockName}</td>
            <td>{item.aisle}</td>
            <td>{item.shelf}</td>
            <td>{item.quantity}</td>
            <td>${typeof item.stockPrice === 'number' ? item.stockPrice.toFixed(2) : 'N/A'}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}