import React from 'react';

class Table extends React.Component {

    constructor(props) {
      super(props);
      this.state = {
          table : this.props.table
      };
    //   this.state = {
    //     id : this.props.id,
    //     bar_reservation_id : this.props.bar_reservation_id,
    //     booked_time : this.props.booked_time,
    //     booked_user : this.props.booked_user,
    //     cancel_time : this.props.cancel_time,
    //     cancel_user : this.props.cancel_user,
    //     capacity : this.props.capacity,
    //     checkin_time : this.props.checkin_time,
    //     checkin_user : this.props.checkin_user,
    //     checkout_time : this.props.checkout_time,
    //     checkout_user : this.props.checkout_user,
    //     discount : this.props.discount,
    //     guest_name : this.props.guest_name,
    //     guest_phone : this.props.guest_phone,
    //     is_cancel : this.props.is_cancel,
    //     name : this.props.name,
    //     code : this.props.code,
    //     people_quantity : this.props.people_quantity,
    //     status : this.props.status,
    //   };
      this.handleClickOnTable = this.handleClickOnTable.bind(this);
    }
  
    handleClickOnTable() {
        this.props.SelectTable(this.props.table);
    }

    render() {
      var table = this.props.table;
      return (
            <div className="col-3 _table" onClick={this.handleClickOnTable}>
                <div className="table-inner">
                    <span>{table.name}</span>
                </div>
            </div>
      );
    }
  
}

  
export default Table;