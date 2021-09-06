import React from "react";
import axios from "axios";
import baseURL from "../api";

function Home(){

    const [url, setUrl] = React.useState({});
    const short_url = React.useRef();

    function addURL(){
        axios.post(`${baseURL}/add`,url).then((res)=>{
           console.log(url);
           short_url.current.innerText = "localhost:3000/" + res.data;
           short_url.current.href = res.data;
       }, (err)=>{console.log("DATA NOT SENT");})
    }


    return(
        <div>
        <h1>Shortme: URL Shortener</h1>
        <input type="text" placeholder="Enter your URL to short..." id="url-input" onChange={(e)=>{
            setUrl({originalURL:e.target.value});
        }}/>
        <button onClick={addURL} id="submit">Shorten</button>
        <h3>Your Short URL: <a href="" target="_blank" ref={short_url} id="short-url"></a></h3>
        </div>
    );
}

export default Home;