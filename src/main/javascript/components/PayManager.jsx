import React from 'react';
import PayInput from "./subComponents/PayInput.jsx";

class PayManager extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        discount : 0,
        vat : 0
    };
    this.handleChangeInput = this.handleChangeInput.bind(this);
    this.handleChangeDiscount = this.handleChangeDiscount.bind(this);
    this.handleChangeVAT = this.handleChangeVAT.bind(this);
  }

  handleChangeInput (e) {
      console.log(e);
    // this.props.onSelectSecondCategory(category);
  }

  handleChangeDiscount (e) {
    this.setState({ discount : e.target.value});
  }

  handleChangeVAT (e) {
    this.setState({ vat : e.target.value});
  }


  render() {
    let items = this.props.items;
    let total_amount = 0;
    let total = 0;
    var total_discount = '';
    var total_vat = '';
    if (items.length) {
        items.forEach(i => {
            total += i.price * i.quantity;
        });    

        total_discount = total * (this.state.discount / 100);
        total_amount = total - total_discount;//Tru discount
        total_vat = total_amount * (this.state.vat / 100);
        total_amount = total_amount - total_vat;//Tru vat
    }

    return (
        <div className="pay-container row no-gutters">
            <PayInput type="text" label="Tổng :" value={total}/>
            <PayInput type="text" label="Giảm giá :" value={this.state.discount} onChange={this.handleChangeDiscount} 
                      msg={total_discount == 0 ? '' : total_discount}/>
            <PayInput type="text" label="VAT :" value={this.state.vat} onChange={this.handleChangeVAT} 
                      msg={total_vat == 0 ? '' : total_vat}/>
            <PayInput type="text" label="Thành tiền :" value={total_amount}/>
        </div>
      );
  }

}

export default PayManager;