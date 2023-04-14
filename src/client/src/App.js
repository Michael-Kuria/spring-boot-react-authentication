import React from "react";
import Login from "./components/login/Login";
import "./index.css";
import SignUp from "./components/sign-in/SignUp";
import { Route, Routes } from "react-router-dom";
import Header from "./components/header/Header";

function App() {
  return (
    <main>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/sign-up" element={<SignUp />} />
      </Routes>
    </main>
  );
}

export default App;
