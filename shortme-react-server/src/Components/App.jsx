import React from "react";
import Home from "./Home";
import Page from "./Page";
import {BrowserRouter as Router, Route} from "react-router-dom";

function App(){

    return (
        <div>
        <Router>
            <Route path="/" component={Home} exact/>
            <Route path="/" component={Page}/>
        </Router>
        </div>
    );
}

export default App;