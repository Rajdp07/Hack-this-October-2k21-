import React, {useState} from 'react';

export default function Textarea(props){
    const [inputVal, setInputVal] = useState(props.value ? props.value : "");
    function changeHandler(e){
        setInputVal(e.target.value);
    }
    return(
        <React.Fragment>
            <label htmlFor={props.id}>{props.label}</label>
            <textarea rows={props.rows} cols={props.cols}  id={props.id} placeholder={props.placeholder} value={inputVal} onChange={changeHandler.bind(this)}></textarea>
        </React.Fragment>
    )
}