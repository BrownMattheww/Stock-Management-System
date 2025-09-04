import { Description, Field, Input, Label } from '@headlessui/react';
import { useState } from 'react';
import './InventoryManager.css';

export default function ModalForm(props) {
  const [modal, setModal] = useState(false);

  const openModal = () => {
    setModal(true);
  };

  const closeModal = () => {
    setModal(false);
  };

  return (
    <div>
      {!modal && (
        <button onClick={openModal}>
          {props.buttonName}
        </button>
      )}

      {modal && (
      <div className="modal-overlay">
      <div className="modal-container">

        <h2 className="modal-title">Create Stock</h2>
        <Field>
          <Label>Stock Name</Label>
          <Description>Input the stock name here</Description>
          <Input />

          <Label>Aisle</Label>
          <Description>Input the aisle here</Description>
          <Input />

          <Label>Shelf</Label>
          <Description>Input the shelf name</Description>
          <Input />

          <Label>Stock Price</Label>
          <Description>Input the stock price here</Description>
          <Input />
        </Field>

      <button onClick={closeModal} className="modal-close-button">
        Close Form
      </button>
    </div>
  </div>
)}
    </div>
  );
}