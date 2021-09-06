import React from "react";
import axios from "axios";
import baseURL from "../api";

function Page(){

    React.useEffect(()=>{
        if(window.location.pathname=="/") return;
        const url = window.location.pathname.replace("/", "");
        axios.get(`${baseURL}/${url}`).then((res)=>{
            window.location.replace(`https://${res.data}`);
       }, (err)=>{alert("Wrong Mapping");
    })}, []);

    return (
        <div>

        </div>
    );
}

export default Page;