import React from 'react';
import SecondCategory from "./subComponents/SecondCategory.jsx";

class SecondCategoryManager extends React.Component {

  constructor(props) {
    super(props);
    this.handleSelectSecondCategory = this.handleSelectSecondCategory.bind(this);
  }

  handleSelectSecondCategory (category) {
    this.props.onSelectSecondCategory(category);
  }

  render() {
    let rows = [];

    if (this.props.category.cateList) {
      this.props.category.cateList.forEach(cate => {
        rows.push(<SecondCategory key={cate.id} 
                                category={cate} 
                                selected={this.props.selected}
                                onClickSecondCategory={this.handleSelectSecondCategory}/>);
      });
    }

    return (
      <div className="row no-gutters cate-child">
        {rows}
      </div>
    );
  }

}

export default SecondCategoryManager;