import React from "react";
import type { Bus } from "../types/bus";
import "../App.css";

interface BusDetailProps {
  bus: Bus | null;
  onClose: () => void;
}

const BusDetail: React.FC<BusDetailProps> = ({ bus, onClose }) => {
  if (!bus) return null;

  return (
    <div className="bus-card" style={{ position: "relative" }}>
      <button
        className="bus-close-btn"
        onClick={onClose}
        aria-label="Cerrar"
        title="Cerrar"
      >
        ×
      </button>
      <h2 className="bus-card-title">Detalle del Bus</h2>
      <p>
        <span className="bus-label">#ID:</span>
        <span className="bus-value">{bus.id}</span>
      </p>
      <p>
        <span className="bus-label">Número:</span>
        <span className="bus-value">{bus.numero}</span>
      </p>
      <p>
        <span className="bus-label">Placa:</span>
        <span className="bus-value">{bus.placa}</span>
      </p>
      <p>
        <span className="bus-label">Marca:</span>
        <span className="bus-value">{bus.marca}</span>
      </p>
      <p>
        <span className="bus-label">Características:</span>
        <span className="bus-value">{bus.caracteristicas}</span>
      </p>
      <p>
        <span className="bus-label">Creado:</span>
        <span className="bus-value">
          {new Date(bus.fechaCreacion).toLocaleString()}
        </span>
      </p>
      <p>
        <span className="bus-label">Activo:</span>
        <span className="bus-value">{bus.activo ? "Sí" : "No"}</span>
      </p>
    </div>
  );
};

export default BusDetail;
