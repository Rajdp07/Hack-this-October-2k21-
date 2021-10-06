import React, { Component } from 'react';

class HeaderComponent extends Component {
    render() {
        return (
            <div>


                <nav class="navbar navbar-expand-lg navbar-light bg-navbar">
                    <a class="navbar-brand" style={{ color: "#FFFFFF" }} href="/profile"><i class="fa fa-star Blink" aria-hidden="true"></i> Profile Management App</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" style={{ color: "#FFFFFF" }} href="/addprofile">Create Profile <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" style={{ color: "#FFFFFF" }} href="/enrichorder">Enrich Order</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" style={{ color: "#FFFFFF" }} href="/orders">Order List</a>
                            </li>

                        </ul>
                    </div>
                </nav>




            </div>
        );
    }
}

export default HeaderComponent;