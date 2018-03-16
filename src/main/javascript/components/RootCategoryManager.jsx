import React from 'react';
import RootCategory from "./subComponents/RootCategory.jsx";

class RootCategoryManager extends React.Component {

  constructor(props) {
    super(props);
    this.handleClickRootCategory = this.handleClickRootCategory.bind(this);
  }

  handleClickRootCategory (category) {
      this.props.onSelectRootCategory(category);
  }

  render() {
    let rows = [];

    this.props.category.forEach(cate => {
        rows.push(<RootCategory key={cate.id} 
                                category={cate} 
                                selected={this.props.selected}
                                onClickRootCategory={this.handleClickRootCategory}/>);
    });

    return (
      <div className="row no-gutters category">
        {rows}
      </div>
    );
  }

}

export default RootCategoryManager;