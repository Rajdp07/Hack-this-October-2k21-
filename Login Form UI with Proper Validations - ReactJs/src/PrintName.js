import React from 'react';

export default class PrintName extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            fname: "",
            lname: ""
        }
    }
    Change(event){
      this.setState({...this.state, fname: event.target.value});
      
      
    }
    Change1(event){
        this.setState({...this.state, lname: event.target.value});
      
    }
    
    Display(){
      var a=parseInt(this.state.fname);
      var b=parseInt(this.state.lname);
      document.getElementById("root1").innerHTML=a+b;
    }
    
    
    render(){
        return(
            <div>
                <input type="text" onChange={this.Change.bind(this)}/>
                <input type="text" onChange={this.Change1.bind(this)}/>
                
                <button onClick={this.Display.bind(this)}>ADD</button>
            </div>
        );
    
    };
    
}