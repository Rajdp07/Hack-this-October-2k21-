import React from 'react';
import Input from './Input';
import Radio from './Radio';
import Select from './Select';
import Textarea from './Textarea';

export default function App(){
    return(
        <div>
            <Input type="text" label="Name:" placeholder="Enter Your First Name" id="firstName"/>
            <br />
            <label>Gender:</label>
            <Radio label="Male" id="male" name="gender" value="male"/>
            <Radio label="Female" id="female" name="gender" value="female"/>
            <br />
            <Input type="email" label="Email Address:" placeholder="Enter Your Email" id="email"/>
            <br />
            <label>Branch:</label>
            <Select id="branch" options={[{value: "Computer Science Engineering", id: "cse"}, {value: "Mechanical Engineering", id: "me"}, {value: "Electronics Engineering", id: "ee"}, {value: "Information Technology", id: "it"}, {value: "Mechatronics", id: "mt"}]} />
            <br />
            <div style={{display: 'flex', alignItems: 'center'}}>
                <label>Describe Yourself:</label>
                <Textarea rows="10" cols="50" id="desciption" placeholder="Describe Yourself" />
            </div>
            <br />
            <button>Submit Form</button>
        </div>
    )
}