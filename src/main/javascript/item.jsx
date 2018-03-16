import ReactDOM from 'react-dom'
import React from "react";
import {browserHistory, IndexRoute, Link, Router, Route} from "react-router";
import Navbar from "./components/subComponents/Navbar.jsx";
import SearchBar from "./components/subComponents/SearchBar.jsx";
import TableList from "./components/TableList.jsx";


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
      filterText : ''
    };

    this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
  }
 
  handleFilterTextChange (filterText) {
    this.setState({ filterText: filterText });
  }

  render () {

    let seach_bar = <SearchBar filterText={this.state.filterText}
                                   onFilterTextChange={this.handleFilterTextChange} />;

    return (
            <div className="row no-gutters">
              <div className="col-5 section">
                <Navbar className="navbar-light bg-light justify-content-between" title_nav="Restaurant" content={seach_bar}/>
                <TableList filterText={this.state.filterText} />
              </div>
              <div className="col-7 section">
                <div className="foods-container row no-gutters">
                  <div className="foods-list col-6">
                    <div className="row no-gutters">
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="foods-selected col-6">
                    <div className="row no-gutters">
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                      <div className="food col-4">
                        <div className="food-inner">
                          <div className="f-name">Trung</div>
                        <div className="f-price">20.000</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="pay-container row no-gutters">
                  <div className="row no-gutters">
                    <div className="col-5">Tong : </div>
                    <div className="col-7">2000000</div>
                  </div>
                </div>
              </div>
            </div>
    );
  }
}


ReactDOM.render(
  <App />,
  document.getElementById('app')
);

