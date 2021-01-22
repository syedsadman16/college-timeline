import React from "react";
import "./Element.css";

function Element({ name, section, color, credits, description, subject }) {

  const h2 = {
    color: "black",
  }

  return (
    <div>
      <div className="activity-div" style={{backgroundColor: color}}>
        <div className="heading">
          <h2 style={h2}> {section} - <i> {subject} </i> </h2>
        </div>
        <h1> {name} </h1>
        <h2 style={h2}> {description} </h2>
        <div className="corner">
          <h2 style={h2}> {credits} cr </h2>
        </div>
      </div>
    </div>
  );
}

export default Element;
