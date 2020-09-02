import React from "react";
import "./Element.css";

function Element({ name, section, color }) {
  return (
    <div>
      <div className="activity-div" style={{backgroundColor: color}}>
        <div className="heading">
          <h2> {section} </h2>
        </div>
        <h1> {name} </h1>
      </div>
    </div>
  );
}

export default Element;
