import axios from 'axios'


const ORDER_REST_API_URL='http://localhost:8081/order/';
class OrderService{
    getOrderDetails(){
        return axios.get(ORDER_REST_API_URL);
    }
    enrichOrder(order){
        return axios.post(ORDER_REST_API_URL+'add',order);
    }
    deleteOrder(orderId){
        return axios.delete(ORDER_REST_API_URL+'deleteorder'+'/'+orderId);
    }
}
export default new OrderService();