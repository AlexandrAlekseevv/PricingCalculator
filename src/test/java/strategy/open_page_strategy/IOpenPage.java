package strategy.open_page_strategy;

import Page.AbstractPage;

@FunctionalInterface
public interface IOpenPage {
    <T extends AbstractPage> T open(T page);
}
