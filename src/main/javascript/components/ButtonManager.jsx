import React from 'react';
import SelectedItem from "./subComponents/SelectedItem.jsx";

class ButtonManager extends React.Component {

  constructor(props) {
    super(props);
    this.handleClickBook = this.handleClickBook.bind(this);
    this.handleClickCheckin = this.handleClickCheckin.bind(this);
    this.handleClickCheckOut = this.handleClickCheckOut.bind(this);
    this.handleClickCancel = this.handleClickCancel.bind(this);
    this.handleClickPay = this.handleClickPay.bind(this);
  }

  handleClickBook () {
      this.props.onBook();
  }

  handleClickCheckin () {
    this.props.onCheckin();
  }

  handleClickCheckOut () {
    this.props.onCheckOut ();
  }

  handleClickCancel () {
    this.props.onCancel();
  }

  handleClickPay () {
    this.props.onPay();
  }

  render() {
      var selectedTable = this.props.selectedTable;
      var buttons = [];
      switch (selectedTable.status) {
          case "EMPTY" :
            buttons.push(<div key="1" className="col-6 btn-book bg-success" onClick={this.handleClickBook}>Đặt bàn</div>);
            buttons.push(<div key="2" className="col-6 btn-checkin bg-primary" onClick={this.handleClickCheckin}>Check-in</div>);
            break;
          case "BOOKED" :
            buttons.push(<div key="1" className="col-6 btn-checkin bg-primary" onClick={this.handleClickCheckin}>Check-in</div>);
            buttons.push(<div key="2" className="col-6 btn-cancel bg-danger" onClick={this.handleClickCancel}>Hủy bàn</div>);
            break;
          case "CHECKIN" :
            buttons.push(<div key="1" className="col-6 btn-payment bg-info" onClick={this.handleClickPay}>Thanh toán</div>);
            buttons.push(<div key="2" className="col-6 btn-checkout bg-warning" onClick={this.handleClickCheckOut}>Check-out</div>);
            break;
          default :
            // buttons.push(<div key="1" className="col-6 btn-book bg-success" onClick={this.handleClickBook}>Đặt bàn</div>);
            // buttons.push(<div key="2" className="col-6 btn-checkin bg-primary" onClick={this.handleClickCheckin}>Check-in</div>);
            break;
      }
    return (
        <div className="row no-gutters button-manager">
            {buttons}
        </div>
    );
  }

}

export default ButtonManager;