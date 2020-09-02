import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import Element from "./Element.js";
import {
  VerticalTimeline,
  VerticalTimelineElement,
} from "react-vertical-timeline-component";
import "react-vertical-timeline-component/style.min.css";
import { Modal } from "react-responsive-modal";
import "react-responsive-modal/styles.css";

function App() {
  const [cardColor, setCardColor] = useState("dodgerblue");
  const [open, setOpenStatus] = useState("");

  return (
    <div className="App">
      <button
        onClick={() => {
          setOpenStatus(true);
          console.log(open);
        }}
      >
        Open modal
      </button>
      <h1>
        {" "}
        The City College of New York '21
        <br /> <i>B.E. Computer Engineering</i>{" "}
      </h1>
      <div>
        <Modal
          open={open}
          onClose={() => {
            setOpenStatus(false);
          }}
        >
          <h2> Create new submission </h2>
          <form>
            <select>
            <option selected value="blue">
                blue
              </option>
              <option value="red">red</option>
            </select>
            <p>Course Number:</p>
            <input type="text" />
            <p>Course Title:</p>
            <input type="text" />
          </form>
        </Modal>
      </div>
      <VerticalTimeline>
        <VerticalTimelineElement
          className="vertical-timeline-element--work"
          contentStyle={{ background: "lightgrey", color: "#fff" }}
          contentArrowStyle={{ borderRight: "7px solid  rgb(33, 150, 243)" }}
          date="2011 - 2010"
          iconStyle={{ background: "rgb(33, 150, 243)", color: "#fff" }}
        >
          <Element name="Software Engineering" section="CSC322" color="red" />
          <Element
            name="Operating Systems"
            section="CSC332"
            color={cardColor}
          />
          <Element
            name="Company Software Engineering"
            section="Internship"
            color="green"
          />
        </VerticalTimelineElement>
        <VerticalTimelineElement
          className="vertical-timeline-element--work"
          contentStyle={{ background: "lightgrey", color: "#fff" }}
          date="2010 - 2011"
          iconStyle={{ background: "rgb(33, 150, 243)", color: "#ff0000" }}
        >
          <Element name="Electromagnetics" section="EE330" />
        </VerticalTimelineElement>
      </VerticalTimeline>
    </div>
  );
}

export default App;
