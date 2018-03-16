import ReactDOM from 'react-dom'
import React from "react";
import {browserHistory, IndexRoute, Link, Router, Route} from "react-router";
import Navbar from "./components/subComponents/Navbar.jsx";
import SearchBar from "./components/subComponents/SearchBar.jsx";
import TableList from "./components/TableList.jsx";
import ItemManager from "./components/ItemManager.jsx";
import SockJsClient from "react-stomp";
import ButtonManager from "./components/ButtonManager.jsx";


const PRODUCTS = [
  {category: 'Sporting Goods', price: '$49.99', stocked: true, name: 'Football'},
  {category: 'Sporting Goods', price: '$9.99', stocked: true, name: 'Baseball'},
  {category: 'Sporting Goods', price: '$29.99', stocked: false, name: 'Basketball'},
  {category: 'Electronics', price: '$99.99', stocked: true, name: 'iPod Touch'},
  {category: 'Electronics', price: '$399.99', stocked: false, name: 'iPhone 5'},
  {category: 'Electronics', price: '$199.99', stocked: true, name: 'Nexus 7'}
];

class App extends React.Component {
  constructor (props) {
    super (props);
    this.state = {
      filterText : '',
      selectedItems : [],
      clientConnected: false,
      messages: [],
      selectedTable : {}
    };

    this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    this.handleSelectItem = this.handleSelectItem.bind(this);
    this.handleSelectTable = this.handleSelectTable.bind(this);

    this.handleClickBook = this.handleClickBook.bind(this);
    this.handleClickCheckin = this.handleClickCheckin.bind(this);
    this.handleClickCheckOut = this.handleClickCheckOut.bind(this);
    this.handleClickCancel = this.handleClickCancel.bind(this);
    this.handleClickPay = this.handleClickPay.bind(this);

    this.onConnect = this.onConnect.bind(this);
    this.onMessageReceive = this.onMessageReceive.bind(this);
  }
 
  handleFilterTextChange (filterText) {
    this.setState({ filterText: filterText });
  }

  handleSelectItem (selectedItems) {
    this.setState({ selectedItems : selectedItems });
  }

  handleSelectTable(table) {
    this.setState({ selectedTable : table });
  }

  handleClickBook() {
    var bookInfo = {
      user_id : 0
    };
    bookInfo.table_id = this.state.selectedTable.id;
    bookInfo.capacity = this.state.selectedTable.capacity;
    bookInfo.status = 'BOOKED';
    bookInfo.items = this.state.selectedItems;
    console.log(bookInfo);
    this.sendMessage('reservation', bookInfo);  
  }
  handleClickCheckin() {
    console.log('handleClickCheckin');
  }
  handleClickCheckOut() {
    console.log('handleClickCheckOut');
  }
  handleClickCancel() {
    console.log('handleClickCancel');
  }
  handleClickPay() {
    console.log('handleClickPay');
  }

  onMessageReceive (msg, topic) {
    console.log(topic);
    console.log(msg);
    this.setState(prevState => ({
      messages: [...prevState.messages, msg]
    }));
  }

  sendMessage (chanel, selfMsg) {
    try {
      this.clientRef.sendMessage("/app/" + chanel, JSON.stringify(selfMsg));
      return true;
    } catch(e) {
      return false;
    }
  }

  onConnect() {
    this.setState({ clientConnected: true }); 
  }

  render () {

    let seach_bar = <SearchBar filterText={this.state.filterText}
                                   onFilterTextChange={this.handleFilterTextChange} />;
    const wsSourceUrl = window.location.protocol + "//" + window.location.host + "/gs-websocket";
    const topics = ["/topic/table", "/topic/reservation"];
    return (
            <div className="row no-gutters">
              <div className="col-5 section">
                <Navbar className="navbar-light bg-light justify-content-between" title_nav="Restaurant" content={seach_bar}/>
                <TableList filterText={this.state.filterText} SelectTable={this.handleSelectTable}/>
              </div>
              <div className="col-7 section">
                <ItemManager onSelectItem={this.handleSelectItem}/>
              </div>
              <ButtonManager onBook={this.handleClickBook}
                             onCheckin={this.handleClickCheckin}
                             onCheckOut={this.handleClickCheckOut}
                             onCancel={this.handleClickCancel}
                             onPay={this.handleClickPay}
                             selectedTable={this.state.selectedTable}/>
              <SockJsClient url={ wsSourceUrl } topics={topics}
                            onMessage={ this.onMessageReceive } ref={ (client) => { this.clientRef = client }}
                            onConnect={this.onConnect}
                            onDisconnect={ () => { this.setState({ clientConnected: false }) } }
                            debug={ false }/>
            </div>
    );
  }
}


ReactDOM.render(
  <App />,
  document.getElementById('app')
);
