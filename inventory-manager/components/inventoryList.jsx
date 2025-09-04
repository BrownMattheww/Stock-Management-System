import { useState, useEffect } from "react";
import ModalForm from "./modalForm";
import './InventoryManager.css';

export default function InventoryList() {
  const [items, setItems] = useState([]);

  // Fetches inventory items and puts them in table
  async function getInventoryItems() {
    try {
      const response = await fetch("http://localhost:8080/stockLocation", { method: "GET" });
      if (!response.ok) {
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
    <>
      <div className="inventory-container">
      <div className="inventory-actions">
        <ModalForm buttonName="Create Stock" />
      </div>

      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Stock Name</th>
            <th>Aisle</th>
            <th>Shelf</th>
            <th>Quantity</th>
            <th>Stock Price</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {items.map(item => (
            <tr key={item.stockId}>
              <td>{item.stockId}</td>
              <td>{item.stockName}</td>
              <td>{item.aisle}</td>
              <td>{item.shelf}</td>
              <td>{item.quantity}</td>
              <td>${typeof item.stockPrice === 'number' ? item.stockPrice.toFixed(2) : 'N/A'}</td>
              <td>
                <button className="edit-button">Edit</button>
                <button className="delete-button">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    </>
  );
}