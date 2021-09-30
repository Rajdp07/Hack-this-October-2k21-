import React from 'react';
import {debounce} from 'lodash';

class Login extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            rightPanelActive: false,
        }
    }
    validateName(e, ind){
        const textDiv = document.getElementsByClassName("validation-signup")[ind];
          if (/^(?=.*[0-9])|(?=.*[`~!@#$%^&*()\-+=|\\[\]{}"':;?/.><,_])/.test( e.target.value)) {
            textDiv.innerText = "Invalid Name";
            e.target.style.outline = "none";
            e.target.style.borderBottom = "2px solid red"
            // console.log(e);
        } else {
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
    }
    validateEmail(e, ind){
        const textDiv = document.getElementsByClassName("validation-signup")[ind];
          if ((!(/^[a-zA-Z0-9]\.{0,1}([a-zA-Z0-9]+\.)*[a-zA-Z0-9]+@([a-z]+\.)+[a-z]{2,4}$/.test(e.target.value)))) {
            textDiv.innerText = "Invalid Email";
            e.target.style.outline = "none";
            e.target.style.borderBottom = "2px solid red"
        } else {
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }

        if(e.target.value === ""){
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
    }
    validateMobileNoLength(e){
        console.log(e);
        if(/(Backspace)|(ArrowRight)|(ArrowLeft)|(Tab)/.test(e.key)){
            return;
        }
        if(e.target.value.length >= 10 || !/[0-9]/.test(e.key)){
            e.preventDefault();
        }
    }
    validateMobileNo(e, ind){
        const textDiv = document.getElementsByClassName("validation-signup")[ind];
        function error(){
            textDiv.innerText = "Invalid Mobile No."
            e.target.style.outline = "none";
            e.target.style.borderBottom = "2px solid red"
        }
        function removeErr(){
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
        if(e.target.value.length < 10){
            error();
        } else {
            removeErr();
        }

        if(e.target.value === ""){
            removeErr();
        }

        if(/^0/.test(e.target.value)){
            textDiv.innerText = "No need of first 0 on Mobile no."
            e.target.style.outline = "none";
                e.target.style.borderBottom = "2px solid red"
        }
    }
    validatepwd(e, ind){
        const textDiv = document.getElementsByClassName("validation-signup")[ind];
          if ((!/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[`~!@#$%^&*()\-+=|\\[\]{}"':;?/.><,_])(?=.{8,})/.test(e.target.value)) || e.target.value === ""){
            textDiv.innerText =
              "The password must contain at least one lowercase letter, one uppercase letter, one number, one special character and must be at least 8 digits long";
            e.target.style.outline = "none";
            e.target.style.borderBottom = "2px solid red"
            } else {
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }

        if(document.getElementById("cpwd").value !== ""){
            this.validateCpwd({target: document.getElementById("cpwd")}, ind+1)
        }

        if(e.target.value === ""){
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
    }
    validateCpwd(e, ind){
        const password = document.getElementById("pwd").value;
        const textDiv = document.getElementsByClassName("validation-signup")[ind];
        if (e.target.value !== password) {
        textDiv.innerText = "Password does not match";
        e.target.style.outline = "none";

            e.target.style.borderBottom = "2px solid red"
            e.target.style.borderBottom = "2px solid red"
        } else {
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
        if(e.target.value === ""){
            textDiv.innerText = null;
            e.target.style.outline = null;
            e.target.style.border = null;
        }
    }
    render(){
        return( 
            <React.Fragment>
                <div id="root">
                    <div className={`container ${this.state.rightPanelActive && "rightPanelActive"}`} id="container">
                        <div className="formContainer signUpContainer">
                            <form>
                                <h1>Create Account</h1>
                                <input type="text" placeholder="First name" name="firstName" id="firstName" tabIndex="1" required onChange={debounce((e) => this.validateName(e, 0), 1000)}/>
                                <div className="validation validation-signup"></div>
                                <input type="text" placeholder="Last name" id="lastName" name="lastName" tabIndex="2" onChange={debounce((e) => this.validateName(e, 1), 1000)} required/>
                                <div className="validation validation-signup"></div>
                                <select id="gender" name="gender" tabIndex="3" required defaultValue="gender">
                                    <option value="gender" disabled >Chose Gender</option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    <option value="others">Others</option>
                                </select>
                                <div className="validation validation-signup"></div>
                                <input type="email" placeholder="Email Id" name="email" id="email" tabIndex="4" onChange={debounce((e) => this.validateEmail(e, 3), 1000)} required/>
                                <div className="validation validation-signup"></div>
                                <input type="text" placeholder="Mobile no." id="mobileNo" name="mobileNo" tabIndex="5" onChange={debounce((e) => this.validateMobileNo(e, 4), 1000)} onKeyDown={(e) => this.validateMobileNoLength(e)} required/>
                                <div className="validation validation-signup"></div>
                                <input type="password" placeholder="Password" name="pwd" id="pwd" tabIndex="6" onChange={debounce((e) => this.validatepwd(e, 5), 1000)} required/>
                                <div className="validation validation-signup"></div>
                                <input type="password" placeholder="Confirm Password" id="cpwd" tabIndex="7" onChange={debounce((e) => this.validateCpwd(e, 6), 1000)} required/>
                                <div className="validation validation-signup"></div>
                                <input type="button" onClick={debounce(e => console.log('clicked'), 1000)} value="Sign up"/>
                            </form>
                        </div>
                        <div className="formContainer signInContainer">
                                    <form action="#">
                                        <h1>Sign in</h1>
                                        <input type="text" placeholder="Email or Mobile No." name="email" id="username" required/>
                                        <input type="password" placeholder="Password" name="pwd" id="login-pwd" required/>
                                        <a href="#">Forgot your password?</a>
                                        <button>Sign In</button>
                                    </form>
                        </div>
                        <div className="overlayContainer">
                            <div className="overlay">
                                <div className="overlayPanel overlayLeft">
                                    <h1>Already a Customer?</h1>
                                    <p>Sign in here</p>
                                    <button className="ghost" id="signIn" onClick={() => this.setState({...this.state, rightPanelActive: false})}>Sign In</button>
                                </div>
                                <div className="overlayPanel overlayRight">
                                    <h1>New to ApniMarket?</h1>
                                    <p>Signup here and start shopping with us</p>
                                    <button className="ghost" id="signUp" onClick={() => this.setState({...this.state, rightPanelActive: true})}>Sign Up</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default Login;