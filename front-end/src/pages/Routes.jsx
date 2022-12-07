import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./Home/Home";
import CreateNewElement from "./AddNewElement/AddNewElement";
import NotFound from "./NotFound/NotFound";

function Body() {
  return (
    <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/add" element={<CreateNewElement />}></Route>
      <Route path="*" element={<NotFound />}></Route>
    </Routes>
  );
}

export default Body;
