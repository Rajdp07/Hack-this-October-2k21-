import axios from 'axios'

const PROFILE_REST_API_URL='http://localhost:8080/profile/details';
const ADD_PROFILE_API='http://localhost:8080/profile/saveprofile'
const UPDATE_PROFILE_API='http://localhost:8080/profile/updateprofile'
const DELETE_PROFILE_API='http://localhost:8080/profile/deleteprofile'

class ProfileService{
    getProfileDetails(){
       return axios.get(PROFILE_REST_API_URL);
    }
    createProfile(profile){
        return axios.post(ADD_PROFILE_API,profile);
    }

    updateProfile(profile,profileId){
        return axios.put(UPDATE_PROFILE_API+'/'+profileId,profile);
    }
    deleteProfile(profileId){
        return axios.delete(DELETE_PROFILE_API+'/'+profileId);
    }
}

export default new ProfileService();