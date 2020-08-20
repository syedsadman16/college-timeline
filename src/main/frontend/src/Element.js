import React from "react";
import "./Element.css";

function Element({ name, section }) {
  return (
    <div>
      <div className="activity-div">
        <div className="heading">
          <h2> {section} </h2>
        </div>
        <h1> {name} </h1>
      </div>
    </div>
  );
}

export default Element;
