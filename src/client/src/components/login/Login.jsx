import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";

import "./login.css";
import { handleLogin } from "../client/Client";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const usernameRef = useRef();

  const resetForm = () => {
    setUsername("");
    setRememberMe(false);
    setPassword("");
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const values = {
      username: username,
      password: password,
      // rememberMe: rememberMe,
    };
    console.log(values);

    handleLogin(values).then((res) => {
      console.log(res.json());
    });

    resetForm();
  };

  useEffect(() => {
    usernameRef.current.focus();
  }, []);

  return (
    <div className="login">
      <div className="login__form form">
        <h2>Login</h2>
        <div>
          <form onSubmit={(e) => handleSubmit(e)}>
            <div className="login__field">
              <label htmlFor="username">Username</label>
              <input
                className="form__input"
                placeholder="Email"
                ref={usernameRef}
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>
            <div className="login__field">
              <label htmlFor="password">Password</label>
              <input
                className="form__input"
                placeholder="Password"
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <label htmlFor="rememberMe" className="login__field--checkbox">
              Remember Me?
              <input
                type="checkbox"
                id="rememberMe"
                value={rememberMe}
                checked={rememberMe}
                onChange={(e) => setRememberMe(e.target.value)}
              />
            </label>
            <button className="btn login__btn">Login</button>
          </form>
          <div className="login__link">
            <Link to="/sign-up">SignIn</Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
