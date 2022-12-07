import React from "react";

function TableElementsView(props) {
  return (
    <div className="background">
      <ul className="list">
        <li className="listElement">{props.id}</li>
        <li className="listElement">{props.firstName}</li>
        <li className="listElement">{props.lastName}</li>
        <li className="listElement">{props.phoneNumber}</li>
        <li className="listElement">{props.email}</li>
      </ul>
    </div>
  );
}

export default TableElementsView;
