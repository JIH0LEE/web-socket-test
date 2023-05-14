import { useRef, useState, useEffect } from "react";
import SockJS from "sockjs-client";
import { Stomp } from "@stomp/stompjs";
import "./App.css";

function App() {
  const client = useRef({});

  let sockJS = new SockJS("http://localhost:8080/ws");
  let stompClient = Stomp.over(sockJS);

  useEffect(() => {
    stompClient.connect({}, () => {
      console.log("connected");
    });
  }, []);
  useEffect(() => {}, []);
  return <div className="App">Hello world</div>;
}

export default App;
