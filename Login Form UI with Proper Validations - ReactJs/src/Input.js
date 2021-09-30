import React, {useState} from 'react';

export default function Input(props){
    const [inputVal, setInputVal] = useState(props.value ? props.value : "");
    function changeHandler(e){
        setInputVal(e.target.value);
    }
    return(
        <React.Fragment>
            <label htmlFor={props.id}>{props.label}</label>
            <input type={props.type} id={props.id} placeholder={props.placeholder} value={inputVal} onChange={changeHandler.bind(this)}/>
        </React.Fragment>
    )
}