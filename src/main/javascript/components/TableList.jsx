import React from 'react';
import "whatwg-fetch";
import Table from "./Table.jsx";

class TableList extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        tableInfo : []
    };
    this.handleSelectTable = this.handleSelectTable.bind(this); 
  }

  componentDidMount () {
    fetch('/api/v1/gettables')
    .then(response => response.json())
    .then(json => {
        // console.log(json);
        // If we have a selected restaurant stored in session storage,
        // e.g. we recently refreshed the page, then use that value if
        // it is still valid.
        // if (sessionStorage.getItem('selected_restaurant')) {

        //     // Check whether the selected restaurant stored in session
        //     // storage is still valid.
        //     let isRestaurantIdValid = json
        //         .find(restaurant => restaurant.id === sessionStorage.getItem('selected_restaurant'));

        //     if (isRestaurantIdValid) {
        //         selectedRestaurant = sessionStorage.getItem('selected_restaurant');
        //     }
        // }

        this.setState({ tableInfo: json });
    });
  }

  handleSelectTable(table) {
    this.props.SelectTable(table);
  }

  render() {
    let ft = this.props.filterText.toLocaleLowerCase();
    let rows = [];

    this.state.tableInfo.forEach(_table => {
        if (_table.name.toLocaleLowerCase().indexOf(ft) === -1) return;
        rows.push(<Table key={_table.id} table={_table} SelectTable={this.handleSelectTable}/>);
    });

    return (
      <div className="tables row no-gutters">
        {rows}
      </div>
    );
  }

}

export default TableList;