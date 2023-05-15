import React from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function MainPage() {
  const navigate = useNavigate();

  const makeChatRoom = () => {
    axios.post("http://localhost:8080/api/chat").then((res) => {
      navigate(`/chat/${res.data.chatId}`);
    });
  };

  return (
    <div>
      <button onClick={makeChatRoom}>채팅방 생성</button>
    </div>
  );
}
export default MainPage;
