import { Routes, Route } from "react-router-dom";
import MainPage from "./page/MainPage";
import ChatRoomPage from "./page/ChatRoomPage";
import "./App.css";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route exact path="/chat/:id" element={<ChatRoomPage />} />
      </Routes>
    </div>
  );
}

export default App;
