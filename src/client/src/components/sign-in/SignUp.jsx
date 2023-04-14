import React, { useState } from "react";

import "./signUp.css";

const SignUp = () => {
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const resetForm = () => {
    setFirstname("");
    setLastname("");
    setEmail("");
    setPassword("");
    setConfirmPassword("");
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const values = {
      firstname: firstname,
      lastname: lastname,
      email: email,
      password: password,
    };

    console.log(values);

    resetForm();
  };
  return (
    <div className="sign-up">
      <div className="sign-up__form form">
        <h1>Sign Up</h1>
        <form onSubmit={(e) => handleSubmit(e)}>
          <div className="sign-up__field">
            <label htmlFor="firstname">Firstname</label>
            <input
              className="form__input"
              placeholder="Firstname"
              type="text"
              id="firstname"
              value={firstname}
              onChange={(e) => setFirstname(e.target.value)}
            />
          </div>
          <div className="sign-up__field">
            <label htmlFor="lastname">Lastname</label>
            <input
              className="form__input"
              placeholder="Lastname"
              type="text"
              id="lastname"
              value={lastname}
              onChange={(e) => setLastname(e.target.value)}
            />
          </div>
          <div className="sign-up__field">
            <label htmlFor="email">Email</label>
            <input
              className="form__input"
              placeholder="Email"
              type="email"
              id="username"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="sign-up__field">
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
          <div className="sign-up__field">
            <label htmlFor="confirm-password">Password</label>
            <input
              className="form__input"
              placeholder="Confirm Password"
              type="password"
              id="confirm-password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </div>
          <button className="btn sign-up__btn">Sign Up</button>
        </form>
      </div>
    </div>
  );
};

export default SignUp;
