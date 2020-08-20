import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Element from "./Element.js"
import {
  VerticalTimeline,
  VerticalTimelineElement,
} from "react-vertical-timeline-component";
import "react-vertical-timeline-component/style.min.css";

function App() {
  return (
    <div className="App">

      <h1> The City College of New York '21<br/> <i>B.E. Computer Engineering</i> </h1> 
        <VerticalTimeline>
          <VerticalTimelineElement
            className="vertical-timeline-element--work"
            contentStyle={{ background: "rgb(33, 150, 243)", color: "#fff" }}
            contentArrowStyle={{ borderRight: "7px solid  rgb(33, 150, 243)" }}
            date="2011 - 2010"
            iconStyle={{ background: "rgb(33, 150, 243)", color: "#fff" }}
          >
            <Element name="Software Engineering" section="CSC322" />
            <Element name="Operating Systems" section="CSC332" />
            <Element name="Company Software Engineering" section="Internship" />
            
          </VerticalTimelineElement>
          <VerticalTimelineElement
            className="vertical-timeline-element--work"
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
