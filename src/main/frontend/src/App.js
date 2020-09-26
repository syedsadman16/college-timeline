import React, { useState, useEffect } from "react";
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
import axios from 'axios';

function App() {
  const [cardColor, setCardColor] = useState("dodgerblue");
  const [open, setOpenStatus] = useState("");
  const [courseNumber, setCourseNumber] = useState("");
  const [courseName, setCourseName] = useState("");
  const [credits, setCredits] = useState("");

  useEffect( () => {
    const url = 'http://localhost:8080';
    axios.get(url).then( (res) => {
      console.log(res.data);
    })
  }, []);

  function submitForm(){
    console.log(cardColor, courseName, courseNumber, credits);
  }

  return (
    <div className="App">

      <button onClick={() => {
          setOpenStatus(true);
          console.log(open);
        }}>
        Open modal
      </button>

      <h1>
        {" "} The City College of New York '21
        <br /> 
        <i>B.E. Computer Engineering</i> {" "}
      </h1>

      <div>
        <Modal open={open} onClose={() => {setOpenStatus(false);}}>
          <h2> Create new submission </h2>
          <form onSubmit={submitForm}>
            <p>Card Color</p>
            <select>
              <option value="blue">blue </option>
              <option value="red">red</option>
            </select>

            <p>Course Number:</p>
            <input 
              name="course_number" 
              type="text"
              value={courseNumber}
              onChange={e=>setCourseNumber(e.target.value)} 
              required />

            <p>Course Name:</p>
            <input
              name="course_name" 
              type="text"
              value={courseName}
              onChange={e=>setCourseName(e.target.value)} 
              required />

            <p>Credits</p>
            <input 
              name="credits" 
              type="text"
              value={credits}
              onChange={e=>setCredits(e.target.value)} 
              required  />

            <button>Save</button>
          </form>
        </Modal>
      </div>

      <VerticalTimeline>
        <VerticalTimelineElement
          className="vertical-timeline-element--work"
          contentStyle={{ background: "lightgrey", color: "#fff" }}
          contentArrowStyle={{ borderRight: "7px solid  rgb(33, 150, 243)" }}
          date="2011 - 2010"
          iconStyle={{ background: "rgb(33, 150, 243)", color: "#fff" }}>

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
          iconStyle={{ background: "rgb(33, 150, 243)", color: "#ff0000" }}>
          <Element name="Electromagnetics" section="EE330" />
        </VerticalTimelineElement>

      </VerticalTimeline>
    </div>
  );
}

export default App;
