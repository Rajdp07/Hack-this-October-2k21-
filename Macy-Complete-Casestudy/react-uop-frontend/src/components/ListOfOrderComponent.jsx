import React, { Component } from 'react';
import OrderService from '../services/OrderService';
class ListOfOrderComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            orderList: []
        }
        this.deleteOrder = this.deleteOrder.bind(this);
    }
    componentDidMount() {
        OrderService.getOrderDetails().then((response) => {
            this.setState({ orderList: response.data })
        });
    }

    deleteOrder(orderId) {
        OrderService.deleteOrder(orderId).then(res => {
            this.setState({ orderList: this.state.orderList.filter(order => order.orderId !== orderId) })
        });
        // this.props.history.push('/orders');
    }
 render() {
        return (
            <div>
                <h1 className="text-center"> Order List</h1>
                <div className="row">
                    <table className="table table-striped table-dark table-hover table-bordered">

                        <thead>
                            <tr>
                                <th>Order Id</th>
                                <th>Order Number</th>
                                <th>Order Type</th>
                                <th>Profile Type</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.orderList.map(orders =>
                                        <tr key={orders.orderId}>
                                            <td>{orders.orderId}</td>
                                            <td>{orders.orderNumber}</td>
                                            <td>{orders.orderType}</td>
                                            <td>{orders.profileType}</td>
                                            <td><button onClick={() => this.deleteOrder(orders.orderId)} className="btn btn-danger">Delete</button></td>
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

export default ListOfOrderComponent;