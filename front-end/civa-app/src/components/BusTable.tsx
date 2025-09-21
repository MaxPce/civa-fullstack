import React, { useEffect, useState } from "react";
import type { Bus } from "../types/bus";
import "../App.css";

interface BusTableProps {
  onSelectBus: (bus: Bus) => void;
}

const BusTable: React.FC<BusTableProps> = ({ onSelectBus }) => {
  const [buses, setBuses] = useState<Bus[]>([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);

  useEffect(() => {
    fetch(`http://localhost:8080/bus?page=${page}`)
      .then((res) => res.json())
      .then((data) => {
        const busesAdaptados = data.content.map((bus: any) => ({
          id: bus.id,
          numero: bus.number,
          placa: bus.plate,
          fechaCreacion: bus.createdAt,
          caracteristicas: bus.features,
          marca: bus.brand?.name ?? "",
          activo: bus.active,
        }));
        setBuses(busesAdaptados);
        setTotalPages(data.totalPages);
      });
  }, [page]);

  const handlePrev = () => setPage((p) => Math.max(0, p - 1));
  const handleNext = () => setPage((p) => Math.min(totalPages - 1, p + 1));

  const handleRowClick = (bus: Bus) => {
    fetch(`http://localhost:8080/bus/${bus.id}`)
      .then((res) => res.json())
      .then((data) => {
        onSelectBus({
          id: data.id,
          numero: data.number,
          placa: data.plate,
          fechaCreacion: data.createdAt,
          caracteristicas: data.features,
          marca: data.brand?.name ?? "",
          activo: data.active,
        });
      });
  };

  return (
    <div className="bus-table-container">
      <table className="bus-table">
        <thead>
          <tr>
            <th>Número</th>
            <th>Placa</th>
            <th>Marca</th>
            <th>Activo</th>
          </tr>
        </thead>
        <tbody>
          {buses.map((bus) => (
            <tr key={bus.id} onClick={() => handleRowClick(bus)}>
              <td>{bus.numero}</td>
              <td>{bus.placa}</td>
              <td>{bus.marca}</td>
              <td>{bus.activo ? "Sí" : "No"}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="bus-pagination">
        <button onClick={handlePrev} disabled={page === 0}>
          Anterior
        </button>
        <span>
          Página {page + 1} de {totalPages}
        </span>
        <button onClick={handleNext} disabled={page === totalPages - 1}>
          Siguiente
        </button>
      </div>
    </div>
  );
};

export default BusTable;
