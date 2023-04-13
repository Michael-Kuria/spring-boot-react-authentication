import { useState } from "react";

import "./login.css";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    const values = {
      username: username,
      password: password,
      rememberMe: rememberMe,
    };
    console.log(values);
  };

  return (
    <div className="login__form">
      <h2>Login</h2>
      <div>
        <form onSubmit={(e) => handleSubmit(e)}>
          <div className="login__field">
            <label htmlFor="username">Username</label>
            <input
              type="text"
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="login__field">
            <label htmlFor="password">Password</label>
            <input
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
          <button className="btn form__btn">Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;
