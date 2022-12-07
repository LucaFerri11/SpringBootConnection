import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./AddNewElement.scss";

function AddNewElement() {
  const baseURL = "http://localhost:8099/user";
  const [isEmpty, setIsEmpty] = useState(false);
  const [newElementCreated, setNewElementCreated] = useState(false);
  const [message, setMessage] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    const newFirstName = e.target[0].value;
    const newLastName = e.target[1].value;
    const newPhoneNumber = e.target[2].value;
    const newEmail = e.target[3].value;
    if (newFirstName == "" || newPhoneNumber == "") {
      setIsEmpty(true);
      setNewElementCreated(false);
    } else {
      for (let i = 0; i <= 3; i++) e.target[i].value = "";
      setIsEmpty(false);
      axios
        .post(baseURL, {
          firstName: newFirstName,
          lastName: newLastName,
          phoneNumber: newPhoneNumber,
          email: newEmail,
        })
        .then((response) => {
          console.log(response);
          setMessage(response.data.message);
          setNewElementCreated(true);
        })
        .catch((error) => {
          setMessage(error.message);
          setNewElementCreated(true);
        });
    }
  };

  return (
    <div>
      <div className="buttonContainer">
        <Link to="/">
          <button className="backButton">Back</button>
        </Link>
      </div>
      <div className="formContainer">
        <form className="form" onSubmit={handleSubmit}>
          <table>
            <tbody>
              <tr>
                <td>
                  <label htmlFor="firstName">*First Name:</label>
                </td>
                <td>
                  <input id="firstName" name="firstName" />
                </td>
              </tr>
              <tr>
                <td>
                  <label htmlFor="lastName">Last Name:</label>
                </td>
                <td>
                  <input id="lastName" name="lastName" />
                </td>
              </tr>
              <tr>
                <td>
                  <label htmlFor="phoneNumber">*Phone Number:</label>
                </td>
                <td>
                  <input id="phoneNumber" name="phoneNumber" />
                </td>
              </tr>
              <tr>
                <td>
                  <label htmlFor="email">E-mail:</label>
                </td>
                <td>
                  <input id="email" name="email" />
                </td>
              </tr>
            </tbody>
          </table>
          <div className="submitBtnContainer">
            <button className="submitBtn" type="submit">
              Submit
            </button>
          </div>
        </form>
      </div>
      <p className="warnings" hidden={!isEmpty}>
        (!) You must fill in all the required fields
      </p>
      <p className="warnings" hidden={!newElementCreated}>
        {message}
      </p>
    </div>
  );
}

export default AddNewElement;
