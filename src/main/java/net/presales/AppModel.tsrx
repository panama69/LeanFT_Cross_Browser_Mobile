<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>AOSAppModel</className>
    <objects>
        <object type="Page" technology="Web">
            <name>Advantage Shopping</name>
            <codeName>AdvantageShoppingPage</codeName>
            <description></description>
            <identification/>
            <children>
                <object type="Link" technology="Web">
                    <name>SPEAKERS</name>
                    <codeName>SPEAKERSLink</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="InnerText" type="string" isRegExp="false">SPEAKERS</property>
                            <property name="TagName" type="string" isRegExp="false">SPAN</property>
                        </properties>
                    </identification>
                </object>
                <object type="Image" technology="Web">
                    <name>fetchImage?image_id=4200</name>
                    <codeName>FetchImageImageId4200Image</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="Alt" type="string" isRegExp="false"></property>
                            <property name="TagName" type="string" isRegExp="false">IMG</property>
                            <property name="Type" type="enum" isRegExp="false">Normal</property>
                        </properties>
                        <index>1</index>
                    </identification>
                </object>
                <object type="Button" technology="Web">
                    <name>save_to_cart</name>
                    <codeName>SaveToCartButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ButtonType" type="string" isRegExp="false">submit</property>
                            <property name="Name" type="string" isRegExp="false">ADD TO CART</property>
                            <property name="TagName" type="string" isRegExp="false">BUTTON</property>
                        </properties>
                    </identification>
                </object>
                <object type="Link" technology="Web">
                    <name>1 </name>
                    <codeName>Link</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="InnerText" type="string" isRegExp="true">.*</property>
                            <property name="Role" type="string" isRegExp="false">link</property>
                            <property name="TagName" type="string" isRegExp="false">A</property>
                        </properties>
                        <index>1</index>
                    </identification>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
