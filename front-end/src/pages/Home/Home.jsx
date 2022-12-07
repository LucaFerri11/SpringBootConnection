import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./Home.scss";
import TableElementObj from "./../../Components/TableElementsObject/TableElementsObject";
import TableElementsView from "./../../Components/TableElementsView/TableElementsView";

function Home() {
  const [elementsSQL, setElementsSQL] = useState([
    new TableElementObj(
      0,
      "Luca",
      "Ferri",
      "123 456 789",
      "luca.ferri@solera.com"
    ),
    new TableElementObj(
      1,
      "Antonio",
      "Rubia",
      "123 456 789",
      "antonio.rubia@solera.com"
    ),
    new TableElementObj(
      2,
      "Rubén",
      "Palomo",
      "123 456 789",
      "ruben.palomo@solera.com"
    ),
  ]);

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
