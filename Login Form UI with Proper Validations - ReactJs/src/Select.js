import React from 'react';

export default function Select(props){
    return(
        <React.Fragment>
            <select id={props.id}>
                {props.options.map((option) => <option value={option.value} id={option.id}>{option.value}</option>)}
            </select>
        </React.Fragment>
    )
}