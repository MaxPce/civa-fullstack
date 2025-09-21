import React, { useState } from "react";
import "./App.css";
import type { Bus } from "./types/bus";
import BusTable from "./components/BusTable";
import BusDetail from "./components/BusDetails";

const App: React.FC = () => {
  const [selectedBus, setSelectedBus] = useState<Bus | null>(null);

  return (
    <div>
      <h1>Lista de Buses</h1>
      <div className="bus-main-content">
        <BusTable onSelectBus={setSelectedBus} />
        <BusDetail bus={selectedBus} onClose={() => setSelectedBus(null)} />
      </div>
    </div>
  );
};

export default App;
