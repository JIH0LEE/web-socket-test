import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import SockJS from "sockjs-client";
import { Stomp } from "@stomp/stompjs";

let sockJS;
let stompClient;

const ChatElem = ({ chatMeta }) => {
  return (
    <div className="chat-elem">
      <div>{chatMeta.sessionId}</div>
      <div>{chatMeta.chat}</div>
    </div>
  );
};

function ChatRoomPage() {
  const [sessionId, setSessionId] = useState(null);
  const [chatList, setChatList] = useState([]);
  const [currentChat, setCurrentChat] = useState("");
  const params = useParams();

  const chatId = params.id;

  useEffect(() => {
    sockJS = new SockJS("http://localhost:8080/ws");
    stompClient = Stomp.over(sockJS);
    stompClient.connect(
      {},
      (data) => {
        setSessionId(data.headers["user-name"]);
        const info = {
          chatId: chatId,
          sessionId: data.headers["user-name"],
        };
        stompClient.subscribe(`/sub/chat/room/${chatId}`, (data) => {
          setChatList(JSON.parse(data.body).chatList);
          console.log(JSON.parse(data.body).chatList);
        });
        stompClient.send("/pub/chat/enter", {}, JSON.stringify(info));
      },
      (err) => {}
    );
    return function cleanup() {
      stompClient.disconnect();
    };
  }, []);

  const send = () => {
    const body = {
      chatId: chatId,
      sessionId: sessionId,
      chat: currentChat,
    };
    setCurrentChat("");
    stompClient.send("/pub/chat/message", {}, JSON.stringify(body));
  };

  const chatHandler = (e) => {
    setCurrentChat(e.target.value);
  };

  return (
    <div className="chat-room">
      <div className="chat-list">
        {chatList.map((chat, idx) => (
          <ChatElem key={idx} chatMeta={chat}></ChatElem>
        ))}
      </div>
      <div className="input-container">
        {" "}
        <input
          classNametype="textarea"
          value={currentChat}
          onChange={chatHandler}
        ></input>
        <button onClick={send}>보내기</button>
      </div>
    </div>
  );
}
export default ChatRoomPage;
