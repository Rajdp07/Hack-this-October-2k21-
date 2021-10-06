import React, { Component } from 'react';
import ProfileService from '../services/ProfileService';

class ListOfProfileComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            profileList: []
        }
        this.addProfile = this.addProfile.bind(this);
        this.editProfile = this.editProfile.bind(this);
        this.deleteProfile = this.deleteProfile.bind(this);
    }
    componentDidMount() {
        ProfileService.getProfileDetails().then((response) => {
            this.setState({ profileList: response.data })
        });
    }
    addProfile() {
        this.props.history.push('/addprofile');
    }
    editProfile(profileId) {
        this.props.history.push(`/updateprofile/${profileId}`);
    }
    deleteProfile(profileId) {
        ProfileService.deleteProfile(profileId).then(res => {
            this.setState({ profileList: this.state.profileList.filter(profile => profile.profileId !== profileId) })
        });

    }
    render() {
        return (
            <div>
                <h1 className="text-center"> Profiles List</h1>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addProfile}>Create Profile</button>
                </div><br></br>

                <div className="row">
                    <table className="table table-striped table-dark table-hover table-bordered">

                        <thead>
                            <tr>
                                <th>Profile Id</th>
                                <th>Profile Name</th>
                                <th>Profile Type</th>
                                <th>Criteria Name</th>
                                <th>Criteria Value</th>
                                <th>Generate Shipment</th>
                                <th>Actions          </th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.profileList.map(

                                    profile =>
                                        <tr key={profile.profileId}>
                                            <td>{profile.profileId}</td>
                                            <td>{profile.profileName}</td>
                                            <td>{profile.profileType}</td>
                                            <td>{profile.criteriaName}</td>
                                            <td>{profile.criteriaValue}</td>
                                            <td>{profile.generateShipment}</td>
                                            <td>
                                                <button onClick={() => this.editProfile(profile.profileId)} className="btn btn-info">Update</button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.deleteProfile(profile.profileId)} className="btn btn-danger">Delete</button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>


                </div>
                <img style={{ display: "block", marginLeft: "auto", marginRight: "auto" }} height="100" width="220" alt="" src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Macy%27s_Inc.png"></img>
            </div>
        );
    }
}

export default ListOfProfileComponent;