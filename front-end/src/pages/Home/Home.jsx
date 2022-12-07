import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./Home.scss";
import TableElementObj from "./../../Components/TableElementsObject/TableElementsObject";
import TableElementsView from "./../../Components/TableElementsView/TableElementsView";

function Home() {
  const baseURL = "http://localhost:8099/user";
  const [elementsSQL, setElementsSQL] = useState([]);

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      if (response.data.data == "") return;
      const parseResponse = JSON.parse(response.data.data);
      let arrayResponse = [];
      parseResponse.forEach((element) => {
        arrayResponse.push(
          new TableElementObj(
            element.id,
            element.firstName,
            element.lastName,
            element.phoneNumber,
            element.email
          )
        );
      });
      setElementsSQL(arrayResponse);
    });
  }, []);

  return (
    <div>
      <div className="scroll">
        <ul className="list title">
          <li className="listElement">
            <strong>ID</strong>
          </li>
          <li className="listElement">
            <strong>FIRST NAME</strong>
          </li>
          <li className="listElement">
            <strong>LAST NAME</strong>
          </li>
          <li className="listElement">
            <strong>PHONE NUMBER</strong>
          </li>
          <li className="listElement">
            <strong>EMAIL</strong>
          </li>
        </ul>
        {elementsSQL.map((element, index) => (
          <TableElementsView
            key={index}
            id={element.id}
            firstName={element.firstName}
            lastName={element.lastName}
            phoneNumber={element.phoneNumber}
            email={element.email}
          />
        ))}
      </div>
      <div className="addButtonContainer">
        <Link to="/add">
          <button className="addButton">+</button>
        </Link>
      </div>
    </div>
  );
}

export default Home;
