import React from "react";
import { Link, Route, Routes } from "react-router-dom";
import "./header.css";
import Login from "../login/Login";

const Header = () => {
  return (
    <header>
      <nav>
        <button className="btn">
          <Link to="/login">Login</Link>
        </button>
        <button className="btn">
          <Link to="/sign-up">Sign Up</Link>
        </button>
      </nav>
    </header>
  );
};

export default Header;
